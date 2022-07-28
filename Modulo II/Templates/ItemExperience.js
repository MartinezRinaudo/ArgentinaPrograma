function listItemExperience(content1, content2, content3, content4, content5, content6, nroList) {
    return `
        <li class="list-group-item list-group-item-light">
            <div class="data-container">
                <div class="list-info-experience">
                    <h4 id="data-list-experience-job-${nroList}">${content1}</h4>
                    <h4><input type="text" class="edit-info-experience-${nroList}" style="display: none;" placeholder="Job"></h4>
                    <h5 id="data-list-experience-place-${nroList}">${content2}</h5>
                    <h5><input type="text" class="edit-info-experience-${nroList}" style="display: none;" placeholder="Place of job"></h5>
                    <h6> <span id="data-list-experience-start-${nroList}">${content3}</span> - <span id="data-list-experience-end-${nroList}">${content4}</span></h6>
                    <h6><input type="date" class="edit-info-experience-${nroList}" style="display: none;" placeholder="Start date"></h6>
                    <h6><input type="date" class="edit-info-experience-${nroList}" style="display: none;" placeholder="End date"></h6>
                    <h6 id="data-list-experience-type-${nroList}">${content5}</h6>
                    <h6><input type="text" class="edit-info-experience-${nroList}" style="display: none;" placeholder="Type of job"></h6>
                    <p id="data-list-experience-skills-${nroList}">${content6}</p>
                    <p><input type="text" class="edit-info-experience-${nroList}" style="display: none;" placeholder="Applied skills"></p>
                    <button class="edit-info-experience-${nroList}" style="display: none;" id="saveChangesEditedsInExperience-${nroList}">Save changes</button>
                </div>
            </div>
            <div>
                <div id="edit-btn-experience-${nroList}"><i class="fa fa-pen"></i></div>
            </div>
        </li>
    `;
}

export { listItemExperience };