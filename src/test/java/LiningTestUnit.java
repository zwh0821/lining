import com.fasterxml.jackson.core.JsonProcessingException;
import com.isuperone.lining.Application;
import com.isuperone.lining.common.helper.AesHelper;
import com.isuperone.lining.model.dto.common.TreeDto;
import com.isuperone.lining.model.entity.biz.BizTask;
import com.isuperone.lining.model.entity.biz.BizTaskTerminalData;
import com.isuperone.lining.model.qo.task.TerminalDataQO;
import com.isuperone.lining.model.vo.task.TaskDataVO;
import com.isuperone.lining.queue.MsgProducer;
import com.isuperone.lining.service.inter.biz.IBizTaskTerminalDataService;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @program: Lining
 * @description: 应用测试单元
 * @author: Joe
 * @create: 2020-03-30 21:31
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LiningTestUnit {

    @Resource
    IBizTaskTerminalDataService bizTaskTerminalDataService;

    @Autowired
    private MsgProducer msgProducer;

    @Value("${system.expries}")
    private String expries;

    @Test
    public void doTest() throws DecoderException {
        String IV = "0102030405060708";
        String key = "9ba4ea8d48a19a84";
        String s = null;
        try {
            s = AesHelper.decryptAES(expries, key, IV);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    @Test
    public void doProjectTreeTest() {
        List<TreeDto> tree = this.bizTaskTerminalDataService.getProjectTree();
        System.out.println(tree);
    }


    @Test
    public void doGetTaskDataTest() {
        BizTask bizTask = new BizTask();
        bizTask.setId(1263036973993938945L);
        TaskDataVO taskDataVO = this.bizTaskTerminalDataService.getBizTaskTerminalData(bizTask);
        System.out.println(taskDataVO);
    }


    @Test
    public void direceMsgTest() throws JsonProcessingException {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("taskId","11111111");
        msgProducer.sendMsg(hashMap,new HashMap<>(),"111111111");
    }
}
