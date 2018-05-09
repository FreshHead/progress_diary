$(function () {
    $(".delete-button").on("click", function (e) {
        e.preventDefault();
        var form = $(this).closest('form');
        form.attr('action', "diary/delete").submit();
    });
});
