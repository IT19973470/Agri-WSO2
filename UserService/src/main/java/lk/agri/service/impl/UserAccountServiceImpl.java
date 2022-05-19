package lk.agri.service.impl;

import lk.agri.dto.UserAccountDTO;
import lk.agri.entity.UserAccount;
import lk.agri.repository.UserAccountRepository;
import lk.agri.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccountDTO login(String email, String password) {
        UserAccount userAccountObj = userAccountRepository.findByEmailAndPassword(email, password);
        return new UserAccountDTO(userAccountObj);
    }

    @Override
    public UserAccountDTO signUp(UserAccount userAccount) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
//        userAccount.setAccId("ACC" + format);
        UserAccountDTO userAccountDTO = new UserAccountDTO(userAccountRepository.save(userAccount));
        userAccountDTO.setPassword(null);
        return userAccountDTO;
    }
}
