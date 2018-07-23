$(document).ready(function () {
    $('#btn_employee_add').on("click", function (e) {
        e.preventDefault();
        var employeeName = $("#employee_name").val();
        if ($.trim(employeeName).length < 2) {
            alert("please, enter correct name");
        }
        else {
            var projectIds = [];
            $(".checkbox :checkbox:checked").each(function () {
                projectIds.push(parseInt($(this).attr("id")));
            });
            $.ajax({
                type: "POST",
                url: "/employees",
                data: {id: null,name: employeeName, projectIds: projectIds},
                success: function () {
                    window.location.reload();
                }
            });
        }
    });

    $('.delete_employee').on("click", function(e){
        e.preventDefault();
        var empId = parseInt($(this).closest("td").attr("id"));

        if(confirm("Delete employee with id = " + empId)){
            $.ajax({
                type:"POST",
                url:"/employee",
                data:{id:empId},
                success:function (data) {
                    $(".delete_employee").closest("td#"+data).parent("tr").fadeOut("slow",function(){
                        $(".delete_employee").closest("td#"+data).parent("tr").remove();
                    });
                }
            });
        }
    });

    $('.edit_employee').on("click", function(e){
        e.preventDefault();
        var id = parseInt($(this).closest("td").attr("id"));

        $.ajax({
            type:"get",
            url:"/employee",
            data:{id:empId},
            success:function (data) {
                $(".delete_employee").closest("td#"+data).parent("tr").fadeOut("slow",function(){
                    $(".delete_employee").closest("td#"+data).parent("tr").remove();
                });
            }
        });
    });
});