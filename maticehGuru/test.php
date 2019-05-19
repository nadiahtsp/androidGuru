<?php
    // echo date("Y-m-d H:i:s");
    $role = 1;
    $status = 0;
    $created_at = date("Y-m-d H:i:s");

    require_once('connection.php');

    // $sql = "INSERT INTO users (name, email, password, no_hp, jenis_kelamin, role, created_at, status)
    //             VALUES ('Rafi','mrafi@mail.com','123321', '086475634', 'Laki-laki', '$role', '$created_at', $status)";
                
    //     try {
	// 		if(mysqli_query($con,$sql)){
	// 			echo 'Register success!';
	// 		}else{
	// 			echo 'Register unsuccessful, please check your code';
	// 		}
	// 	} catch (Exception $e) {
	// 	    echo 'Caught exception: ',  $e->getMessage(), "\n";
	// 	}

		$email = "mrafi@mail.com";
        $password = "123321";

        $sql = "SELECT COUNT(*) as status FROM users where email = '$email' AND password = '$password';";

        //Mendapatkan Hasil
        try {
            $r = mysqli_query($con,$sql);
            $row = mysqli_fetch_array($r);
            $result = array();
            
            array_push($result,array(
                "status"=>$row['status']
			));
			
			echo json_encode(array('result'=>$result));
        } catch (Exception $e) {
            echo 'Caught exception: ',  $e->getMessage(), "\n";
        }
		
		mysqli_close($con);
?>