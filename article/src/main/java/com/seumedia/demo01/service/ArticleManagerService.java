package com.seumedia.demo01.service;

import com.seumedia.demo01.entity.Article_detail;
import com.seumedia.demo01.entity.Article_Info;
import com.seumedia.demo01.entity.Article_picture;
import com.seumedia.demo01.entity.Article_vedio;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleManagerService {
    //从作者角度考虑需求
    //保存文章（包括info，detail，图片，视频）
    int saveArticle(Article_Info article_info, Article_detail article_detail, Article_picture article_picture, Article_vedio article_vedio);

    int article_maxid_return();
//    根据输入的id，version等消息返回实体
    Article_Info selectInfoByIdVersion(long id,long version);
    Article_detail selectDetailByIdVersion(long article_id,long article_version);
    Article_picture selectPictureByIdVersion(long article_id,long article_version);
    Article_vedio selectVedioByIdVersion(long article_id,long article_version);

    //根据特定id和版本去删除文章（包括info，detail，图片，视频）
    int deletedById_verison(long id,  long version);

    //更新文章（包括info，detail，图片，视频）
    int updateArticle(Article_Info article_info, Article_detail article_detail, Article_picture article_picture, Article_vedio article_vedio);

    //第三方角度进行查看
    Article_Info selectByAuthorId(int author_id);


    //审核者角度
    //    根据输入的id返回实体
    List<Article_Info> getInfoAllById(long id);
    List<Article_Info> getInfoAll();
    List<Article_detail> getDetailAll();
    List<Article_picture> getPictureAll();
    List<Article_vedio> getVedioAll();

//    审核状态暂且不动
//    int selectStatus(Long id);   //查看当前最新的version
//    int updateStatus(Long id, Integer status, Integer version);





}
