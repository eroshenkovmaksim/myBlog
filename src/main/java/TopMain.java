import com.ncblog.GenericRepository;
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

        repUser.add(ura);
        repUser.add(max);
        repUser.addPostToUser("Privetik",ura);

//        Post post = new Post("privetiki");
//        Post post2 = new Post("aloha");
//
//        post.setUser(ura);
//        post2.setUser(ura);
//        ura.getPosts().add(post);
//        ura.getPosts().add(post2);
//
//        repPost.add(post);
//        repPost.add(post2);
//        System.out.println(ura.getPosts());
    }
}
