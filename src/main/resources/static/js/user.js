let index = {
    init: function() {
        $("#btn-save").on("click", () => {
            ;
            this.save();
        });
        $("#btn-update").on("click", () => {
            ;
            this.update();
        });
    },

    save:function(){
        let data={
            username:$("#username").val(),
            password:$("#password").val(),
            email:$("#email").val()
        };

        $.ajax({
            type:"POST",
            url:"/auth/joinProc",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8", //body데이터가 어떤타입인지
            dataType:"json" //요청을 서버로해서 응답이 왔을 때 json이라면 javascript오브젝트로 변경, ajax 버전이 오르면서 디폴트로 바뀜
        }).done(function(resp){
            alert("회원가입이 완료되었습니다.");
            location.href="/"
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    update:function(){
        let data={
            id:$("#id").val(),
            password:$("#password").val(),
            email:$("#email").val()
        };

        $.ajax({
            type:"PUT",
            url:"/user",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("회원수정이 완료되었습니다.");
            location.href="/"
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();