$(document).ready(function () {
    $('#btn_project_add').on("click", function (e) {
        e.preventDefault();
        var projectName = $("#project_name").val();
        if ($.trim(projectName).length < 2) {
            alert("please, enter correct name");
        }
        else {
            var projectIds = [];
            $(".checkbox :checkbox:checked").each(function () {
                projectIds.push(parseInt($(this).attr("id")));
            });
            $.ajax({
                type: "POST",
                url: "/projects",
                data: {id: null, name: projectName, projectIds: projectIds},
                success: function () {
                    window.location.reload();
                }
            });
        }
    });

    $('.delete_project').on("click", function(e){
        e.preventDefault();
        var empId = parseInt($(this).closest("td").attr("id"));

        if(confirm("Delete project with id = " + empId)){
            $.ajax({
                type:"POST",
                url:"/project",
                data:{id:empId},
                success:function (data) {
                    $(".delete_project").closest("td#"+data).parent("tr").fadeOut("slow",function(){
                        $(".delete_project").closest("td#"+data).parent("tr").remove();
                    });
                }
            });
        }
    });

    $('.edit_project').on("click", function(e){
        e.preventDefault();
        var id = parseInt($(this).closest("td").attr("id"));

        $.ajax({
            type:"get",
            url:"/project",
            data:{id:empId},
            success:function (data) {
                $(".delete_project").closest("td#"+data).parent("tr").fadeOut("slow",function(){
                    $(".delete_project").closest("td#"+data).parent("tr").remove();
                });
            }
        });
    });
});