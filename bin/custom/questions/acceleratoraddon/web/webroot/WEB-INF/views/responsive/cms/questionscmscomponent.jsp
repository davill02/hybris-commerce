<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="font-size: ${fontSize}; color: #0A246A">
    <div class="container">
        <div class="row">
            <div class="col-lg-offset-0"><h4>Standard questions: </h4></div>
        </div>
        <c:forEach var="question" items="${questions}">
            <div class="row">
                <div class="col-lg-offset-1"> Customer: ${question.questionCustomerName} </div>
            </div>
            <div class="row">
                <div class="col-lg-offset-1"><strong>Q:</strong> ${question.question}</div>
            </div>
            <div class="row">
                <div class="col-lg-offset-1"> Answered customer: ${question.answerCustomerName} </div>
            </div>
            <div class="row">
                <div class="col-lg-offset-1"><strong>A:</strong> ${question.answer}</div>
            </div>
        </c:forEach>
    </div>
</div>