function test() {
    layui.use('layer',
    function() {
        layer.msg('hello');
    });
}

$(function() {
    $.get("/schedule",
    function(schedules) {
        $.each(schedules,
        function(i, schedule) {
            var html = '<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>' + '<div class="layui-timeline-content layui-text">' + '<h3 class="layui-timeline-title">' + schedule.date + '</h3>' + '<p>' + schedule.content + '</p>' + '</div></li>';
            $("#schedule").before(html);
        });
        $.each(schedules,
                function(i, schedule) {
                    var html = '<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>' + '<div class="layui-timeline-content layui-text">' + '<h3 class="layui-timeline-title">' + schedule.date + '</h3>' + '<p>' + schedule.content + '</p>' + '</div></li>';
                    $("#schedule").before(html);
                });

    });
    $(".sulne-schedule").click(function() {
        $('#scheduleModal').modal('show');
        setTimeout(function() {
            $('#scheduleModal div[contenteditable="true"]').focus()
        },
        500);
    });
});