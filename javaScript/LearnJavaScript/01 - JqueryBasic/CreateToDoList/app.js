var $newTask = $("#new-task");
var $submitTask = $("#submitTask");
var $incomplete = $("#incomplete-tasks");
var $completeTask = $("#completed-tasks");

function addNewTask() {
	var newList = $('<li></li>');
	var newLabel = $('<label></label>');
	var newText = $('<input type="text" class="editTask">');
	newText.hide();
	newText.prop("value", $newTask.val());
	newList.append('<input type="checkbox">');	
	newLabel.append($newTask.val());
	newList.append(newLabel);
	newList.append(newText);
	newList.append('<button class="edit">Edit</button>');
	newList.append('<button class="done">Done</button>');
	$incomplete.append(newList);
	$newTask.val('');
}

$submitTask.click(addNewTask);

function deleteParent(list) {
	list.addClass("tobeDeleted");
	$(".tobeDeleted").remove();
}

function addToComplete(taskComplete) {
		//add to completed task:
		var newList = $('<li></li>');
		var newLabel = $('<label></label>');
		newLabel.append(taskComplete);
		newList.append(newLabel);
		newList.append('<button class="delete">Delete</button>');
		$completeTask.append(newList);
};

$incomplete.on("click","li .edit",function() {
	var textEdit = $(this).prev();
	textEdit.toggle();
	edittedTask = textEdit.val();
	textEdit.prev().html(edittedTask);
});

$incomplete.on("click","li .done",function() {
	var taskComplete = $(this).prev().prev().prev().text();
	addToComplete(taskComplete);
	//Delete this element:
	deleteParent($(this).parent());

});


$completeTask.on("click","li .delete",function() {
	deleteParent($(this).parent());
});

$("#allDone").click(function() {
	$('input[type=checkbox]').each(function () {
		var taskComplete =  $(this).next().text();
		addToComplete(taskComplete);
		deleteParent($(this).parent());
	});
});