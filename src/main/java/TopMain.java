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
        Post post = new Post("privetiki");

        repUser.add(ura);
        repUser.add(max);
        repPost.add(post);
    }
}
