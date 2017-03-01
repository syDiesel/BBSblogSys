$(document).ready(function(){



var speed=40; 
var demo=document.getElementById("demo"); 
var demo2=document.getElementById("demo2"); 
var demo1=document.getElementById("demo1"); 



var nnn=200/demo1.offsetHeight;

for(i=0;i<nnn;i++){demo1.innerHTML+= demo1.innerHTML}
demo2.innerHTML = demo1.innerHTML    //克隆demo2为demo1
function Marquee(){
    if(demo2.offsetTop-demo.scrollTop<=0)    //当滚动至demo1与demo2交界时
        demo.scrollTop-=demo1.offsetHeight    //demo跳到最顶端
    else{
        demo.scrollTop++     //如果是横向的 将 所有的 height top 改成 width left 
    }
}
var MyMar = setInterval(Marquee,speed);        //设置定时器
demo.onmouseover = function(){clearInterval(MyMar);}    //鼠标经过时清除定时器达到滚动停止的目的
demo.onmouseout = function(){MyMar = setInterval(Marquee,speed);}    //鼠标移开时重设定时器


});


