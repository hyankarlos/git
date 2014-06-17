<%-- 
    Document   : alterar
    Created on : 27/11/2012, 21:04:21
    Author     : Hyan
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
    <f:view>
        <head>
            <f:loadBundle
                basename="br.jsf.mensagens"
                var="msgs" />
            <title>
                <h:outputText value="#{msgs.Alterar}"/>
            </title>
        </head>
        <body>
            <%@include file="cabecalho.html"%>
            <h3><center>:. Alteração de Usuarios.: </center></h3>
        <h:form><center>
                <h:dataTable value="#{agenda.editar}" var="dados" border="0">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="#{msgs.Cod}"/>
                        </f:facet>
                        <h:outputText value="#{agenda.idusuario}"   />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="#{msgs.Nome}"/>
                        </f:facet>
                        <h:inputText value="#{agenda.nome}" size="30" /><!--recebe o parametro titulo e coloca no input -->
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="#{msgs.Login}"/>
                        </f:facet>
                        <h:inputText value="#{agenda.login}" size="30" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="#{msgs.Senha}"/>
                        </f:facet>
                        <h:inputText value="#{agenda.senha}" size="30" />
                    </h:column>

                </h:dataTable>
                <h:commandButton action="#{agenda.alterar}" value="Gravar" />
                <h:commandLink action="#{agenda.voltar}" value="Voltar"/>
            </center></h:form>
        </body>
</f:view>

</html>
