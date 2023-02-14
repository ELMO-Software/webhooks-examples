# Java Webhooks Project
An example of webhooks java verification process.

# Installation
1. Install all dependencies.
2. Run server
```bash
./mvnw spring-boot:run
```

3. Add file webhooks-public.cer to root folder.
4. Verify webhook signature passes by sending a payload of the webhook with the elmo-webhook-signature header.