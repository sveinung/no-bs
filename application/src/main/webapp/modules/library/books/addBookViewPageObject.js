define(function(require) {

    var po = require('po');
    var poAjax = require('modules/components/po-ajax');
    var poVisibility = require('modules/components/po-visibility');
    var sinon = require('sinon');

    var dropDownViewPageObject = require('modules/components/dropdown/dropDownViewPageObject');

    return po.create({
        author: po.input(".author-input"),
        title: po.input(".title-input"),
        cancel: po.button(".cancel-button"),
        submit: po.button(".submit-button"),
        genre: function(genre) {
            dropDownViewPageObject(this.$el.find(".genres-dropdown")).
                openMenu().
                chooseOption(genre);
            return this;
        },
        save: function() {
            return this.mockRequest(function() {
                this.submit();
            }, this);
        },
        fillIn: function() {
            return this.author("George R.R. Martin").
                title("A Game of Thrones").
                genre("Epic fantasy");
        }
    }, poVisibility, poAjax);
});
