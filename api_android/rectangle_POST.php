<?php 
$rong=$_POST['chieurong'];
$dai=$_POST['chieudai'];
$chuvi=($dai+$rong)*2;
$dientich=$dai*$rong;

echo "Chu vi: ".$chuvi." dien tich: ".$dientich;
?>