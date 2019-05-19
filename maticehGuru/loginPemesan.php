<?php
    require_once('connection.php');
    if($_SERVER['REQUEST_METHOD']=='POST'){
        
        $email = $_POST['email'];
        $password = $_POST['password'];

        $sql = "SELECT COUNT(*) as status FROM users where email = '$email' AND password = '$password';";

        //Mendapatkan Hasil
        try {
            $r = mysqli_query($con,$sql);
            $row = mysqli_fetch_array($r);
            $result = array();
            
            array_push($result,array(
                "status"=>$row['status']
            ));
            
            //Menampilkan dalam format JSON
	        echo json_encode(array('result'=>$result));
        } catch (Exception $e) {
            echo 'Caught exception: ',  $e->getMessage(), "\n";
        }
        

        // try {
		// 	if(mysqli_query($con,$sql)){
		// 		echo 'Login success!';
		// 	}else{
		// 		echo 'Login unsuccessful, please check your code';
		// 	}
		// } catch (Exception $e) {
		//     echo 'Caught exception: ',  $e->getMessage(), "\n";
        // }
        
        mysqli_close($con);
    }
?>