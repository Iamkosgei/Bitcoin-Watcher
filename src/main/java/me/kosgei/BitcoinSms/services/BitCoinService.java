package me.kosgei.BitcoinSms.services;

import me.kosgei.BitcoinSms.controller.SMSSenderController;
import me.kosgei.BitcoinSms.model.AtPayload;
import me.kosgei.BitcoinSms.model.Data;
import me.kosgei.BitcoinSms.model.Message;
import org.springframework.stereotype.Service;

@Service
public class BitCoinService {
    private double currentPrice = 0;

    public void saveBitcoin(Data data) {
        AtPayload atPayload = new AtPayload("sandbox","+25471111111","");
        SMSSenderController smsSenderController = new SMSSenderController();

        if (Double.parseDouble(data.getAmount()) == currentPrice) {
            System.out.println("Price has not changed");
        } else {
            if (currentPrice == 0) {
                atPayload.setMessage(getMessage("Starting price", data));
                smsSenderController.sendSMS(atPayload);

            } else if (Double.parseDouble(data.getAmount()) > currentPrice) {

                atPayload.setMessage( getMessage("Price has gone up", data));
                smsSenderController.sendSMS(atPayload);
            } else {
                atPayload.setMessage(getMessage("Price has dipped", data));
                smsSenderController.sendSMS(atPayload);
            }
        }

    }

    private String getMessage(String message, Data data)
    {
        Message newMessage = new Message(message,data);
        currentPrice = Double.parseDouble(data.getAmount());
        System.out.println(newMessage.getMessage() + " To KSH:" + formatCurrencyToKsh(Double.parseDouble(data.getAmount())));
        return  newMessage.getMessage() + " To KSH:" + formatCurrencyToKsh(Double.parseDouble(data.getAmount()));
    }

    private String formatCurrencyToKsh(double amount) {
        double exchangeRate = 103.86;
        return String.format("%,.2f", amount * exchangeRate);
    }
}
