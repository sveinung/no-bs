define(function(require) {

    require('css!./addBookView.css');
    var template = require('text!./addBookView.mustache'),
        renderTemplate = require('base/renderTemplate'),
        rivets = require('rivets');

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
            el.html(renderTemplate(template));

            rivets.bind(el, {
                cancel: cancelButtonClicked,
                submit: submitButtonClicked
            });
        };

        return {
            render: render
        };
    };

    return AddBookView;
});
