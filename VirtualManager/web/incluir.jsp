<%-- 
    Document   : incluir
    Created on : 27/11/2012, 21:03:26
    Author     : Hyan
--%>
<%@page contentType="text/html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
    <f:view>
        <head>
            <f:loadBundle
                basename="br.com.vm.mensagens"
                var="msgs" />
            <title> <h:outputText value="#{msgs.Inserir}"/> </title>
            <link rel="stylesheet" href="css/base.css"/>
        </head>
        <body>
        <center>
            <h3><center>:. Cadastro de Usuarios.: </center></h3>
                    <h:form>
                        <h:panelGrid columns="2" border="0">
                            <h:outputText value="Nome:"/>
                            <h:inputText value="#{agenda.nome}" size="40" />
                            <h:outputText value="CPF:"/>
                            <h:inputText value="#{agenda.cpf}" size="40" />
                            <h:outputText value="Login:"/>
                            <h:inputText value="#{agenda.login}" size="15" />
                            <h:outputText value="Senha:"/>
                            <h:inputText value="#{agenda.senha}" size="15" />
                        </h:panelGrid>
                        <h:commandButton action="#{agenda.inserir}" value="Enviar" />
                        <h:commandLink action="#{agenda.voltar}" value="Voltar"/>
                    </h:form></center>
    </body>
</f:view>
</html>
