define(function(require) {

    var DropDownView = require('modules/components/dropdown/dropDownView');
    var dropDownViewPageObject = require('modules/components/dropdown/dropDownViewPageObject');

    describe('DropDownView', function() {
        it('opens the dropdown', function() {
            var view = createDropDownView();
            view.render();

            dropDownViewPageObject(view.$el).
                expectToBeHidden().
                openMenu().
                expectToBeVisible();
        });

        it('defaults to showing default option', function() {
            var view = createDropDownView({ defaultOption: 'Choose!' });
            view.render();

            dropDownViewPageObject(view.$el).
                expectToHaveChosen("Choose!");
        });

        it('chooses an option', function() {
            var view = createDropDownView({ options: ['Satire'] });
            view.render();

            dropDownViewPageObject(view.$el).
                openMenu().
                chooseOption("Satire").
                expectToHaveChosen("Satire");
        });
    });

    function createDropDownView(opts) {
        opts = opts || {};

        var options = [];
        if (opts.options) {
            options = _.map(opts.options, function(option) {
                return { value: option };
            })
        }

        return new DropDownView({
            defaultOption: opts.defaultOption || "default option",
            options: options
        });
    }
});
