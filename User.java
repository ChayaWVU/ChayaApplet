package domain.chaya;

/**
 * Created by Tony on 4/4/16.
 */
public class User {


        private String email;
        private String password;

        public User(String email, String password) {
            this.email = email;
            this.password = password;
        }
        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }

}
