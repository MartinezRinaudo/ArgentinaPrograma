function listItemProject(content1, content2, content3, c4,c5,c6, numberOfList) {
    return `
    <li class="list-group-item list-group-item-light">
        <div class="data-container">
            <div class="list-info-project">
                <div class="project-name">
                    <h5 id="data-list-project-name-${numberOfList}">${content1}</h5>
                    <h5><input type="text" class="edit-info-project-${numberOfList}" style="display: none;" id="data-list-project-name-edit" placeholder="Name"></h5>
                    <h6 id="data-list-project-place-${numberOfList}">${content2}</h6>
                    <h6><input type="text" class="edit-info-project-${numberOfList}" style="display: none;" id="data-list-project-place-edit" placeholder="Place"></h6>
                </div>
                <div class="project-details">
                    <p id="data-list-project-description-${numberOfList}">${content3}</p>
                    <p><input type="text" class="edit-info-project-${numberOfList}" style="display: none;" id="data-list-project-description-edit" placeholder="Description"></p>
                    <button class="edit-info-project-${numberOfList}" style="display: none;" id="saveChangesEditedsInProject-${numberOfList}">Save changes</button>        
                </div>
            </div>
        </div>
        <div><div id="edit-btn-projects-${numberOfList}"><i class="fa fa-pen"></i></div></div>                 
    </li>
    `;
}

export {listItemProject};