$("#enviarTransacao").click(validaEnvioTransacao);

function validaEnvioTransacao(){
    let podeEnviar = true;
    let dinheiro = $("#dinheiro").val();
    let valorTransacao = $("#valorTransacao").val();

    if(dinheiro == null){
        podeEnviar = false;
    }
    if(valorTransacao == null){
        podeEnviar = false;
    }
    if(podeEnviar){
        $.ajax({
            type: "POST",
            url: "/transacao",
            data:{
                dinheiro:dinheiro,
                valorTransacao:valorTransacao,
            },
            success: function (data){
                if(data.sucesso){
                    alert("Deu bom!");
                }else{
                    alert(data);
                }
            },
            error: function (){
                $("#errorMessage").append("Deu muito ruim parça!", data);
            }
        });
    }
}