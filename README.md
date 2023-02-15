# webhooks
This is a repository shows working examples of how you could could configure and setup your server to recieve and verify the authencity of ELMO webhooks. It includes examples of servers in the following frameworks:
## Server Examples

- [Java w/ springboot.](java-app)
- [NodeJS w/ express.](express-app)
- [PHP w/ symfony.](php-app)
- [Python w/ flask.](python-app)

## Ngrok setup
For ELMO webhooks to communicate with your server, you must make your server accessible to the internet. One way to do so is to use a service 'Ngrok' which can expose your local development server to the internet with minimal effort.

To setup Ngrok, follow the steps below:
1. Install Ngrok via NPM. 
```bash
npm install ngrok -g 
```
4. Run your local server, taking note of the port.
5. Start a tunnel with Ngrok, using the port running on your local server.
```bash
ngrok http <port> 
```
4. Copy the forwarding address and attach any defined controller routes that are able to handle ELMO webhook requests.
```bash
e.g.  http://xxxx-xx-xxx-xxx-xx.ngrok.io/webhooks 
```
5. Use the copied link for your webhook request url.

*Disclaimer*: ELMO is not affliated with Ngrok in any way. Use Ngrok as your own risk.
___


For more details about ELMO webhooks, there is a medium guide which you can check out: **YET TO BE PUBLISHED**
