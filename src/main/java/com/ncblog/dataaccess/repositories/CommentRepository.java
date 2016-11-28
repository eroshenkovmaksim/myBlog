package com.ncblog.dataaccess.repositories;

import com.ncblog.dataaccess.specifications.users.CommentWhich;
import com.ncblog.dataaccess.specifications.users.PostWhich;
import com.ncblog.dataaccess.specifications.users.UserWhich;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;
import org.hibernate.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 06.11.2016.
 */
public class CommentRepository extends GenericRepository<Comment> {
    Set<Comment> comments = new HashSet<>();
    public CommentRepository() {
        super(Comment.class);
    }
    public void addCommentToPostByUser(User user, Post post, Comment comment){
        if(comments.contains(comment)){
            this.update(comment);
        }else {
            comment.setUser(user);
            comment.setPost(post);
            this.add(comment);
        }
        comments.add(comment);
    }
    public List<Comment> getCommentsInPost(Post post){
        List<Comment> comments = this.getEvery(CommentWhich.belongsToPost(post.getPost_id()));
        return comments;
    }
    public List<Comment> getPostComments(Post post){
        GenericDao<Comment> dao = super.getDao();
        dao.openCurrentSession();
        Query query = dao.getCurrentSession().createQuery("from Comment where post = :post ");
        query.setParameter("post", post);
        List<Comment> comments = query.list();
        dao.closeCurrentSession();
        return comments;
    }
}
