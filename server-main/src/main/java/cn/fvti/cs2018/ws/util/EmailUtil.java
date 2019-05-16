package cn.fvti.cs2018.ws.util;

import cn.fvti.cs2018.ws.bean.dto.EmailObj;
import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

import java.util.concurrent.Executors;

/**
 * @author gsd
 * 邮件服务器
 */
@Slf4j
public class EmailUtil {
    public static void sendEmail(EmailObj obj) {

        Email email = EmailBuilder.startingBlank()
                .from("fz_gao", "fz_gao@163.com")
                .to(obj.getToEmail().substring(0, obj.getToEmail().indexOf("@")), obj.getToEmail())
                .withSubject(obj.getSubject())
                .withHTMLText(obj.getHtmlText())
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.163.com", 25, obj.getFromEmail(), "woshi00266")
                .withSessionTimeout(10 * 1000)
                .withDebugLogging(true)
                .buildMailer();
        mailer.sendMail(email);
    }

    public static void sendSSLEmail(EmailObj obj) {

        Email email = EmailBuilder.startingBlank()
                .from("fz_gao", "fz_gao@163.com")
                .to(obj.getToEmail().substring(0, obj.getToEmail().indexOf("@")), obj.getToEmail())
                .withSubject(obj.getSubject())
                .withHTMLText(obj.getHtmlText())
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.163.com", 994, obj.getFromEmail(), "woshi00266")
                .trustingAllHosts(true)
                .withTransportStrategy(TransportStrategy.SMTPS)
                .withSessionTimeout(10 * 1000)
                .withDebugLogging(true)
                .buildMailer();
        mailer.sendMail(email);
    }

    public static void asySendEmail(EmailObj obj) {
        final ListeningExecutorService executor = MoreExecutors.listeningDecorator(
                Executors.newCachedThreadPool());

        ListenableFuture<Void> sendEmailJob = executor.submit(()->{
            EmailUtil.sendSSLEmail(obj);
            return null;
        });


        Futures.addCallback(sendEmailJob, new FutureCallback<Void>() {

            @Override
            public void onSuccess(Void v) {
                log.info("Send email success...");
            }

            @Override
            public void onFailure(Throwable t) {
                log.info("throw exception ", t);
            }
        }, executor);
    }
}
