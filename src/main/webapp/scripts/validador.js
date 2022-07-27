function validar(){
    let nome = formContato.nome.value
    let fone = formContato.fone.value
    if (nome === ""){
        alert('preencha o nome')
        formContato.nome.focus()
        return false
    }else if(fone === ""){
        alert('preencha o telefone')
        formContato.fone.focus()
        return false
    }else{
        document.forms["formContato"].submit()
    }
}