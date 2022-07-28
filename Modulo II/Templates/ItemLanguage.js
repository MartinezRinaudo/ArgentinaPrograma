function listItemLanguage(content1, content2, c3, c4, c5, c6, nroList) {
    return `
    <li class="list-group-item list-group-item-light">
        <div class="list-info-languages">
            <h6 id="data-list-languages-lang-${nroList}">${content1}: ${content2}</h6>
            <h6><input class="edit-info-language-${nroList}" type="text" placeholder="Insert languages and level"  style="display: none;"></h6>
            <button class="edit-info-language-${nroList}" style="display: none;" id="saveChangesEditedsInLanguages-${nroList}">Save changes</button>
        </div>
        <div>
            <div id="edit-btn-languages-${nroList}"><i class="fa fa-pen"></i></div>
        </div>
    </li>
    `;
}

export { listItemLanguage };