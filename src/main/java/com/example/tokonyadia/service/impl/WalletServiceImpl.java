package com.example.tokonyadia.service.impl;

import com.example.tokonyadia.dto.request.WalletRequest;
import com.example.tokonyadia.dto.response.WalletResponse;
import com.example.tokonyadia.entity.Customer;
import com.example.tokonyadia.entity.Wallet;
import com.example.tokonyadia.repository.WalletRepository;
import com.example.tokonyadia.service.CustomerService;
import com.example.tokonyadia.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@NoArgsConstructor
@AllArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final CustomerService customer_service;
    private final WalletRepository wallet_repository;

    //    @Autowired
    //    private CustomerService customer_service;
    //    private WalletRepository wallet_repository;

    //    sebelum ada Spring
    //    private CustomerService customer_service = new CustomerService(new CustomerRepository());

    //    new WalletServiceImpl(new CustomerService(), new WalletRepository())

    //    @NoArgsConstructor
    //    public WalletServiceImpl(){}
    //    @Autowired
    //    public WalletServiceImpl(CustomerService customer_service, WalletRepository wallet_repository){
    //       this.customer_service = customer_service;
    //       this.wallet_repository = wallet_repository;
    //    }
    //    private final String abc = "abc";

    @Override
    public WalletResponse create(WalletRequest request) {
        String customer_id = request.getCustomer_id();
        Customer customer = customer_service.get_by_id(customer_id);
//        Wallet wallet = new Wallet();
//        wallet.setCustomer(customer);
//        wallet.setBalance(request.getBalance());
        Wallet wallet = Wallet.builder().balance(request.getBalance()).customer(customer).build();
        Wallet createdWallet = wallet_repository.saveAndFlush(wallet);
        // alternativenya modelMapper
        return WalletResponse.builder().id(createdWallet.getId()).balance(createdWallet.getBalance()).customer_id(customer_id).build();
    }

    @Override
    public List<Wallet> get_all() {
        return wallet_repository.findAll();
    }

    @Override
    public Wallet get_by_id(String id) {
        Optional<Wallet> wallet = wallet_repository.findById(id);
        return wallet.orElse(null);
    }

    @Override
    public Wallet update(Wallet request) {
        this.get_by_id(request.getId());
        return wallet_repository.save(request);
    }

    @Override
    public void delete(String id) {
        this.get_by_id(id);
        wallet_repository.deleteById(id);
    }
}
