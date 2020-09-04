package com.seumedia.demo01.mapper;

import com.seumedia.demo01.entity.Article_vedio;
import com.seumedia.demo01.entity.Article_picture;
import com.seumedia.demo01.entity.Article_detail;
import com.seumedia.demo01.entity.Article_Info;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.lang.Integer;

@Repository
public interface ArticleManagerMapper {
        Article_Info SelectInfoByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
        Article_detail SelectDetailByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
        Article_picture SelectPictureByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
        Article_vedio SelectVedioByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
        List<Article_Info> selectInfoAllById(@Param("id") long id);

        int Insert_ArticleInfo(Article_Info article_info);
        int Insert_ArticleDetail( Article_detail article_detail);
        int Insert_ArticlePicture( Article_picture article_picture);
        int Insert_ArticleVedio( Article_vedio article_vedio);

        int DeleteInfoByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
        int DeleteDetailByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
        int DeletePictureByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
        int DeleteVedioByIdVersion(@Param("article_id") long id, @Param("article_version") long version);

        Article_Info selectByAuthorId(@Param("author_id") long author_id);
        List<Article_Info> selectInfoAll();


        int Article_id_max_return();   //返回当前表中最大的id






//    List<Article_Info> SelectArticle(Long authorid, Integer status, Integer pageStart, Integer pageSize);
//    int SelectCount(Long authorid, Integer status);
//    int InsertArticle(Article article);
//    int UpdateArticle(Article article);
//    Long SelectUserIdByCountId(Long id);
//    int UpdataStatus(Long id, Integer status, Integer version);
//    int SelectStatus(Long id, Integer version);*/
}
