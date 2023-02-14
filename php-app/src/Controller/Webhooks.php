<?php
// src/Controller/LuckyController.php
namespace App\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\JsonResponse;

class Webhooks
{
    public function verify(Request $request): JsonResponse
    {
        $signature = $request->headers->get('elmo-webhook-signature');
        $payload = $request->getContent();
        $certificate = file_get_contents("webhooks-public.cer");
        $publicKey = openssl_get_publickey($certificate);
        $isVerified = openssl_verify($payload, base64_decode($signature), $publicKey, 'SHA256');
        return new JsonResponse(
            array(
                'publicKey' => $isVerified
            )
        );
    }
}
