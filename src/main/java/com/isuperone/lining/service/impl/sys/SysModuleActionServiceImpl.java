package com.isuperone.lining.service.impl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isuperone.lining.common.enumration.PermissionEnum;
import com.isuperone.lining.common.exception.ServiceException;
import com.isuperone.lining.mapper.sys.SysModuleActionMapper;
import com.isuperone.lining.model.dto.system.ActionDto;
import com.isuperone.lining.model.dto.system.PermissionDto;
import com.isuperone.lining.model.dto.system.SysModuleActionDto;
import com.isuperone.lining.model.entity.sys.SysModule;
import com.isuperone.lining.model.entity.sys.SysModuleAction;
import com.isuperone.lining.model.vo.sys.ActionVO;
import com.isuperone.lining.model.vo.sys.PermissionVO;
import com.isuperone.lining.service.inter.sys.ISysModuleActionService;
import com.isuperone.lining.service.inter.sys.ISysModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author john
 * @since 2020-04-13
 */
@Service
public class SysModuleActionServiceImpl extends ServiceImpl<SysModuleActionMapper, SysModuleAction> implements ISysModuleActionService {

    @Resource
    private ISysModuleService sysModuleService;

    @Override
    public Page<SysModuleActionDto> findModuleActionPage(Page<SysModuleActionDto> page, SysModule sysModule) {
        sysModule.setMenu(false);
        this.baseMapper.findModuleActionPage(page, sysModule);
        List<SysModuleActionDto> actionDtos = page.getRecords();
        page.setRecords(this.handlerAction(actionDtos));
        return page;
    }

    @Override
    public void saveModuleAction(SysModuleActionDto sysModuleActionDto) {
        if (sysModuleActionDto.getModuleId() == null) {
            throw new ServiceException("模块名称不能为空");
        }
        QueryWrapper<SysModuleAction> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("moduleId", sysModuleActionDto.getModuleId());
        List<SysModuleAction> sysModuleActions = this.baseMapper.selectList(queryWrapper);
        List<SysModuleAction> addModuleActions = new ArrayList<>();
        Date now = new Date();
        for (String actionString : sysModuleActionDto.getActions()
        ) {
            Optional<SysModuleAction> optional = sysModuleActions.stream().filter(s -> s.getAction().equals(actionString)).findFirst();
            if (!optional.isPresent()) {
                SysModuleAction sysModuleAction = new SysModuleAction();
                sysModuleAction.setAction(actionString);
                String descrption = PermissionEnum.getValue(actionString);
                sysModuleAction.setDescription(descrption);
                sysModuleAction.setCreateTime(now);
                sysModuleAction.setDefaultCheck(false);
                sysModuleAction.setModuleId(sysModuleActionDto.getModuleId());
                addModuleActions.add(sysModuleAction);
            } else {
                SysModuleAction sysModuleAction = optional.get();
                sysModuleActions.remove(sysModuleAction);
            }
        }
        if (sysModuleActions.size() > 0) {
            List<Long> perimissionList = sysModuleActions.stream().
                    map(actions -> actions.getId()).collect(Collectors.toList());
            this.baseMapper.deleteBatchIds(perimissionList);
        }
        if (addModuleActions.size() > 0) {
            this.saveBatch(addModuleActions);
        }

    }

    @Override
    public List<PermissionDto> getPermissonData() {
        //step1： 获取所有的module
        SysModule sysModule = new SysModule();
        sysModule.setMenu(false);
        List<SysModule> sysModuleList = this.sysModuleService.findModuleList(sysModule);
        //step2: 获取所有的menu
        sysModule.setMenu(true);
        List<SysModule> menuList = this.sysModuleService.findModuleList(sysModule);
        //step3: 遍历所有的module，获取module下的所有action
        List<PermissionDto> permissionDtos = new ArrayList<>();
        List<SysModuleAction> moduleActions = this.list();
        sysModuleList.forEach(s -> {
            PermissionDto permission = handlerPerimission(s, moduleActions);
            permission.setChildren(handlerChildrenPermission(s.getId(), menuList, moduleActions));
            permissionDtos.add(permission);
        });
        return permissionDtos;
    }


    private List<PermissionDto> handlerChildrenPermission(Long parentId, List<SysModule> menuList, List<SysModuleAction> moduleActions) {
        List<PermissionDto> permissionDtos = new ArrayList<>();
        List<SysModule> childrenList = menuList.stream().filter(s -> s.getParentId().equals(parentId)).collect(Collectors.toList());
        childrenList.forEach(s -> {
            PermissionDto permission = handlerPerimission(s, moduleActions);
            permissionDtos.add(permission);
        });
        return permissionDtos;
    }

    private PermissionDto handlerPerimission(SysModule sysModule, List<SysModuleAction> moduleActions) {
        List<ActionDto> actionList = new ArrayList<>();
        moduleActions.forEach(m -> {
            if (m.getModuleId().equals(sysModule.getId())) {
                ActionDto actionVO = new ActionDto();
                actionVO.setAction(m.getAction());
                actionVO.setDescribe(m.getDescription());
                actionList.add(actionVO);
            }
        });
        PermissionDto permissionDto = new PermissionDto();
        permissionDto.setPermissionId(sysModule.getUrl());
        permissionDto.setName(sysModule.getModuleName());
        permissionDto.setActionData(actionList);
        return permissionDto;
    }

    private List<SysModuleActionDto> handlerAction(List<SysModuleActionDto> list) {
        for (SysModuleActionDto item : list
        ) {
            QueryWrapper<SysModuleAction> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("moduleId", item.getId());
            List<SysModuleAction> actionList = this.baseMapper.selectList(queryWrapper);
            item.setActionDtos(actionList);
            List<String> actionData = new ArrayList<>();
            for (SysModuleAction action : actionList
            ) {
                actionData.add(action.getAction());
            }
            if(actionData.size() > 0){
                item.setActions(actionData);
            }else{
                item.setActions(Collections.emptyList());
            }
            //如果不是菜单，则可能有children
            if (!item.getMenu()) {
                SysModule sysModule = new SysModule();
                sysModule.setParentId(item.getId());
                List<SysModuleActionDto> childrenList = this.baseMapper.findModuleActionList(sysModule);
                item.setChildren(handlerAction(childrenList));
            }
        }
        return list;
    }

}
