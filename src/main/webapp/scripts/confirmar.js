function confirmar(idcon){
    let resposta = confirm("Excluir contato?")
    if(resposta === true){
        window.location.href = "delete?idcon=" + idcon;
    }
}