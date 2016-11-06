import com.ncblog.GenericRepository;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;

/**
 * Created by Администратор on 04.11.2016.
 */
public class TopMain {
    public static void main(String args[]) {
        User ura = new User("Minin", "yura");
        User max = new User("Max","krasava");
        GenericRepository<User> repUser = new GenericRepository<>(User.class);
        GenericRepository<Post> repPost = new GenericRepository<>(Post.class);
        Post post = new Post("privetik");
        Post post2 = new Post("aloha");
        repUser.add(ura);
        repUser.add(max);
        repUser.addPostToUser(post, ura);
        repUser.addPostToUser(post2,ura);
        repUser.addLikeToPostByUser(max,post);
        repUser.addLikeToPostByUser(ura,post);

        Comment comment = new Comment("nice");
        repUser.addCommentToPostByUser(ura,post,comment);

        System.out.print("ura's 1st post got ");
        System.out.print(post.getPosts_likes().size());
        System.out.println(" likes");


    }
}
