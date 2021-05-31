

const InputArea = {
    init(el) {
        this.el = el;
        this.render();
    },
    render() {
        const inputEl = `<input type="text">`;
        this.el.innerHTML = inputEl;
    },
    getValue() {
        return this.el.querySelector('input').value;
    }
};

export default InputArea;