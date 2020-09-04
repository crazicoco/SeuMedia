package com.seumedia.demo01.service.impl;

import com.seumedia.demo01.entity.Article_Info;
import com.seumedia.demo01.entity.Article_detail;
import com.seumedia.demo01.entity.Article_picture;
import com.seumedia.demo01.entity.Article_vedio;
import com.seumedia.demo01.mapper.ArticleManagerMapper;
import com.seumedia.demo01.service.ArticleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManagerServiceImpl implements ArticleManagerService{

    @Autowired
    ArticleManagerMapper articleManagerMapper;


    @Override
    public int saveArticle(Article_Info article_info, Article_detail article_detail, Article_picture article_picture, Article_vedio article_vedio) {
        int h1 = articleManagerMapper.Insert_ArticleInfo(article_info);
        return h1;
    }

    @Override
    public int updateArticle(Article_Info article_info, Article_detail article_detail, Article_picture article_picture, Article_vedio article_vedio) {
        return 0;
    }

    @Override
    public Article_Info selectByAuthorId(int author_id) {
        return null;
    }

    @Override
    public List<Article_Info> getInfoAllById(long id) {
        return articleManagerMapper.selectInfoAllById(id);
    }

    @Override
    public List<Article_Info> getInfoAll() {
        return articleManagerMapper.selectInfoAll();
    }

    @Override
    public List<Article_detail> getDetailAll() {
        return null;
    }

    @Override
    public List<Article_picture> getPictureAll() {
        return null;
    }

    @Override
    public List<Article_vedio> getVedioAll() {
        return null;
    }

    @Override
    public int article_maxid_return() {

        return articleManagerMapper.Article_id_max_return();
    }

    @Override
    public Article_Info selectInfoByIdVersion(long id, long version) {
        return articleManagerMapper.SelectInfoByIdVersion(id,version);
    }

    @Override
    public Article_detail selectDetailByIdVersion(long article_id, long article_version) {
        return articleManagerMapper.SelectDetailByIdVersion(article_id, article_version);
    }

    @Override
    public Article_picture selectPictureByIdVersion(long article_id, long article_version) {
        return articleManagerMapper.SelectPictureByIdVersion(article_id,article_version);
    }

    @Override
    public Article_vedio selectVedioByIdVersion(long article_id, long article_version) {
        return articleManagerMapper.SelectVedioByIdVersion(article_id,article_version);
    }


    //删除所有以此id和version作为索引的info,detail,picture,vedio。
    @Override
    public int deletedById_verison(long id, long version) {
        if (articleManagerMapper.SelectInfoByIdVersion(id, version) != null){
            if(articleManagerMapper.DeleteInfoByIdVersion(id, version)<= 0){
                return -1;
            }
            if(articleManagerMapper.SelectDetailByIdVersion(id,version)!=null) {
                if (articleManagerMapper.DeleteDetailByIdVersion(id, version) <= 0) {
                    return -1;
                }
            }
            if(articleManagerMapper.SelectPictureByIdVersion(id,version)!=null) {
                if (articleManagerMapper.DeletePictureByIdVersion(id, version) <= 0) {
                    return -1;
                }
            }
            if(articleManagerMapper.SelectVedioByIdVersion(id,version)!=null) {
                if (articleManagerMapper.DeleteVedioByIdVersion(id, version) <= 0) {
                    return -1;
                }
            }
        }else{
            return -1;
        }
        return 1;
    }

}
