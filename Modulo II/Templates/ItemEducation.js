function listItemEducation(content1, content2, content3, content4, c5, c6, numberOfList) {
    return `
        <li class="list-group-item list-group-item-light">
            <div class="data-container">
                <div class="list-info-education">
                    <h4 id="data-list-education-name-${numberOfList}">${content1}</h4>
                    <h4><input type="text" class="edit-info-education-${numberOfList}" style="display: none;" placeholder="Education name"></h4>
                    <h5  id="data-list-education-place-${numberOfList}">${content2}</h5>
                    <h5><input type="text" class="edit-info-education-${numberOfList}" style="display: none;" placeholder="Place of studies"></h5> 
                    <h6> <span id="data-list-education-start-${numberOfList}">${content3}</span> - <span id="data-list-education-end-${numberOfList}">${content4}</span></h6>
                            <h6><input type="date" class="edit-info-education-${numberOfList}" style="display: none;" placeholder="Start date"></h6>
                            <h6><input type="date" class="edit-info-education-${numberOfList}" style="display: none;" placeholder="End date"></h6>
                            <button class="edit-info-education-${numberOfList}" style="display: none;" id="saveChangesEditedsInEducation-${numberOfList}">Save changes</button> 
                        </div>
                    </div>
                    <div>
                        <div id="edit-btn-education-${numberOfList}"><i class="fa fa-pen"></i></div>
                    </div>
        </li>
    `;
}

export { listItemEducation };