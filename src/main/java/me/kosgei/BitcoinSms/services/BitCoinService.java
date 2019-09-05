package me.kosgei.BitcoinSms.services;

import me.kosgei.BitcoinSms.model.Bitcoin;
import me.kosgei.BitcoinSms.model.Data;
import me.kosgei.BitcoinSms.repository.BitCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BitCoinService  {

    @Autowired
    BitCoinRepository bitCoinRepository;

    public List<Data> getAllBitcoins()
    {
        List<Data> data = new ArrayList<>();
        bitCoinRepository.findAll().forEach(data::add);
        return data;
    }

    public void saveBitcoin(Data data)
    {
        if(getAllBitcoins().size() ==0)
        {
            bitCoinRepository.save(data);
        }
        else {
            Data data1 = getAllBitcoins().get(0);
            if (data1.getAmount().equals(data.getAmount()))
            {
                System.out.println("Price has not changed");
            }
            else if(Double.parseDouble(data1.getAmount()) > Double.parseDouble(data.getAmount())  ) {
                bitCoinRepository.deleteAll();
                bitCoinRepository.save(data);
                System.out.println("Price has dipped");
            }
            else if (Double.parseDouble(data1.getAmount()) < Double.parseDouble(data.getAmount()) ){
                bitCoinRepository.deleteAll();
                bitCoinRepository.save(data);
                System.out.println("Price has gone up");
            }
        }

    }
}
