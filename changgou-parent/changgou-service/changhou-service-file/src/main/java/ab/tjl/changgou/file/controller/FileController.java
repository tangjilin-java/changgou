package ab.tjl.changgou.file.controller;

import ab.tjl.changgou.file.util.FastDFSFile;
import ab.tjl.changgou.file.util.FastDFSUtil;
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
    @PostMapping
    public Result upload(@RequestParam(value = "file")MultipartFile file) throws Exception {
        //封装文件信息
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(),//文件名
                file.getBytes(),//文件字节数组
                StringUtils.getFilenameExtension(file.getOriginalFilename())//获取文件扩展名
        );
        //调用FastDFSFile类将文件传入到FastDFS中
        String[] uploads = FastDFSUtil.upload(fastDFSFile);

        //拼接访问地址 URL=http://192.168.211.132:8080/group1/M00/00/00/andiu.jpg
        String url = "http://192.168.211.132:8080/"+uploads[0]+"/"+uploads[1];
        return new Result(true, StatusCode.OK,"上传成功！",url);
    }
}
