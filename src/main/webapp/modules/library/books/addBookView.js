define(function(require) {

    require('css!./addBookView.css');
    var template = require('text!./addBookView.mustache'),
        mustache = require('mustache');

    var AddBookView = function(options) {
        var el = options.el;

        var cancelButtonClicked = function(event) {
            event.preventDefault();
            el.addClass('hide');
        };

        var submitButtonClicked = function(event) {
            event.preventDefault();
        };

        var render = function() {
            el.html(mustache.render(template));

            el.find('.cancel-button').click(cancelButtonClicked);
            el.find('.submit-button').click(submitButtonClicked);
        };

        return {
            render: render
        };
    };

    return AddBookView;
});
