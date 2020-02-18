package ab.tjl.changgou.file.controller;

import ab.tjl.changgou.file.util.FastDFSClient;
import ab.tjl.changgou.file.util.FastDFSFile;
import entity.Result;
import entity.StatusCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author:TangJiLin
 * @Description:文件上传控制层
 * @Date: Created in 2020/2/16 10:21
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/upload")
@CrossOrigin
public class FileController {

    /**
     * 文件上传
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public Result uploadFile(MultipartFile file){
        try{
            //判断文件是否存在
            if (file == null){
                throw new RuntimeException("文件不存在");
            }
            //获取文件的完整名称
            String originalFilename = file.getOriginalFilename();
            if (StringUtils.isEmpty(originalFilename)){
                throw new RuntimeException("文件不存在");
            }

            //获取文件的扩展名称  abc.jpg   jpg
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            //获取文件内容
            byte[] content = file.getBytes();

            //创建文件上传的封装实体类
            FastDFSFile fastDFSFile = new FastDFSFile(originalFilename,content,extName);

            //基于工具类进行文件上传,并接受返回参数  String[]
            String[] uploadResult = FastDFSClient.upload(fastDFSFile);

            //封装返回结果
            String url = FastDFSClient.getTrackerUrl()+uploadResult[0]+"/"+uploadResult[1];
            return new Result(true,StatusCode.OK,"文件上传成功",url);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(false, StatusCode.ERROR,"文件上传失败");
    }
}
