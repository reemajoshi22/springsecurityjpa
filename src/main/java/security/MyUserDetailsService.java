package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.models.User;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       // return new MyUserDetails(s); // it returns default
        Optional<User> user=userRepository.findByUsername(s);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));

        return user.map(MyUserDetails::new).get();
    }
}
