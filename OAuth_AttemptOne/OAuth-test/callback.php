<?php 
$client_id = '262837351694-771q5dpj8bsc213sm2jkjsirp8jp7ir5.apps.googleusercontent.com';
$client_secret = 'YC6euuo7xR04NnwinMN1E1Rp';
$redirect_uri= "http://localhost:8080/callback.php";
$authorization_code = $_GET['code'];
if(!$authorization_code){
    die('something went wrong!');
}
$url = 'https://connect.squareup.com/oauth2/token';
$data = array(
    'client_id' => $client_id,
    'client_secret' => $client_secret,
    'redirect_uri' => $redirect_uri,
     'code' => $authorization_code
 );
$options = array(
    'http' => array(
        'header'  => "Content-type: application/json\r\n",
        'method'  => 'POST',
        'content' => json_encode($data)
    )
);
$context  = stream_context_create($options);
$result = file_get_contents($url, false, $context);
var_dump($result);
?>