package com.app.webhooks.controllers;

import java.io.FileInputStream;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhooksController {

    @PostMapping(value = "/webhooks")
    public HashMap<String, String> index(
        @RequestBody String payload,
        @RequestHeader Map<String, String> headers
    )
    {
        HashMap<String, String> results = new HashMap<>();
        boolean isVerified = false;
        // Get the public key from certificate
        try {
            Signature sig = Signature.getInstance("SHA256withRSA");
            FileInputStream file = new FileInputStream("webhooks-public.cer");
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(file);
            
            String base64Signature = headers.get("elmo-webhook-signature");
            byte[] signature = Base64.getDecoder().decode(base64Signature);
            
            sig.initVerify(certificate);
            sig.update(payload.getBytes());
            isVerified = sig.verify(signature);

        } catch(Exception e) {
            System.out.println(e);
        }

        results.put("isVerified", Boolean.toString(isVerified));
        return results;
    }
}
