<?php
$a=$_POST['a'];
$b=$_POST['b'];
$c=$_POST['c'];

$delta=pow($b,2)-4*$a*$c;

$ketqua="";

if ($a==0) {
    if ($b==0) {
        $ketqua= "Vo so nghiem";
    }else{
        $x1= -$c/$b;
        $ketqua= "PT co 1 nghiem duy nhat ".$x1;
    }
}else{
    if($delta<0){
        $ketqua="PT vo nghiem";
    }else{
        $x1= ((-$b+sqrt($delta)))/(2*$a);
        $x2= ((-$b-sqrt($delta)))/(2*$a);

        $ketqua="PT co 2 nghiem phan biet x1: ".$x1 . " x2: ".$x2;
    }
}
echo "Ket qua ".$ketqua;
?>