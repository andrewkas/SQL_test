package com.noirix.security.service;

import com.noirix.domain.Role;
import com.noirix.domain.SystemRoles;
import com.noirix.domain.User;
import com.noirix.repository.RoleRepository;
import com.noirix.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceProvider implements UserDetailsService {
    UserRepository userRepository;
    RoleRepository roleRepository;



    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
       try{
           Optional<User> searchResult=userRepository.findByLogin(name);
           if(searchResult.isPresent()){
           User user =searchResult.get();
           return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),
                   AuthorityUtils.commaSeparatedStringToAuthorityList(roleRepository.findUserRoles(user.getId())
                           .stream()
                           .map(Role::getRoleName)
                           .map(SystemRoles::name)
                           .collect(Collectors.joining(",")))
           );
       }
           else throw new UsernameNotFoundException(String.format("NO user with login '%s'.",name));

           }
       catch (Exception e){
           throw new UsernameNotFoundException("NO user with this login");

           }
    }


}
