// JavaScript Document
/**
 * 使用json中的属性值替换模板中的属性值，模板中的属性值使用$符号包裹，如：$name$
 * 
 * @param {}
 *            obj
 * @return {}
 */
String.prototype.useJson = function(obj) {
	return this.replace(/\$\w+\$/gi, function(matchs) {
				var returns = obj[matchs.replace(/\$/g, "")];
				return (returns + "") == "undefined" ? "" : returns;
			});
};

// 单元格选择初始化函数
function initTdSelect(selName, inputName) {
	$("[name='" + selName + "']").click(function() {
		var currentTd = $(this);
		$("[name='" + selName + "']").each(function() {
					if (currentTd.text() == $(this).text()) {
						$(this).attr("class", "blue_bg");
						$("[name='" + inputName + "']").val($.trim(currentTd
								.text()));
					} else {
						$(this).attr("class", "gray_bg");
					}
				});
	});
}

function initTdSelectWithAttrName(selName, attrName, inputName) {
	$("[name='" + selName + "']").click(function() {
		var currentTd = $(this);
		$("[name='" + selName + "']").each(function() {
			if (currentTd.text() == $(this).text()) {
				$(this).attr("class", "blue_bg");
				$("[name='" + inputName + "']").val($.trim(currentTd
						.attr(attrName)));
			} else {
				$(this).attr("class", "gray_bg");
			}
		});
	});
}

// 打开页面
function winOpen(url) {
	if(url.indexOf("?")<0){url+="?"};
	window.open(encodeURI(url + '&isFromUrl=true'), '_blank');
}

// 检查是否为空
function checkNull(id, name) {
	if ($("#" + id).val() == "" || $("#" + id).val() == null) {
		$("#" + id).focus();
		alert("请填写 " + name);
		return false;
	}
	return true;
}

// 检查手机号格式
function checkTelephone(id, name) {
	if (!checkNull(id, name))
		return false;

	var phoneNumReg = /(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
	if (!phoneNumReg.test($("#" + id).val())) {
		alert(name + " 中填写的不是电话号码");
		$("#" + id).focus();
		return false;
	}
	return true
}

// 检查账号格式
function checkAccount(id, name) {
	if (!checkNull(id, name))
		return false;

	var accountReg = /^[a-zA-Z][_a-zA-Z0-9]{4,17}$/;
	if (!accountReg.test($("#" + id).val())) {
		alert("账号不符合格式要求");
		$("#" + id).focus();
		return false;
	}
	return true
}

// 检查身份证号格式
function checkIDcard(id, name) {
	if (!checkNull(id, name))
		return false;

	var accountReg = /(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
	if (!accountReg.test($("#" + id).val())) {
		alert("身份证号不符合格式要求");
		$("#" + id).focus();
		return false;
	}
	return true
}

// 什么都不检查
function checkSomething(id, name) {
	return true;
}

// 检查数字
function isNumber(s) {
	var regu = "^[0-9]+$";
	var re = new RegExp(regu);
	if (s.search(re) != -1) {
		return true;
	} else {
		return false;
	}
}

// 检查数字
function checkNumber(id, name) {
	var numStr = $("#" + id).val();
	if (isNaN(numStr)) {
		alert(name + " 只能填写数字");
		$("#" + id).focus();
		return false;
	} else {
		return true;
	}
}

// 选择部门或者人员;输入参数为subject的前,取subject对应的input对象的id前缀。
function selectSubject(inputIdPre, toSubTree, district, departmentId,
		userAccount) {
	var returnValue = window.showModalDialog(
			'/10088/Auth/Servlet?method=getDepartmentsAndUsers&toSubTree='
					+ toSubTree + '&district=' + district + '&departmentId='
					+ departmentId + '&userAccount=' + userAccount, '',
			'dialogHeight:600px;dialogWidth:970px;resizable:yes;maximize:yes');

	// 返回的格式为
	// subjectType,subjectId,subjectName,departmentId,departmentName,district
	if (returnValue != null) {
		var subArray = returnValue.split(',');

		var SubjectType = $('#' + inputIdPre + 'SubjectType');
		if (SubjectType)
			$(SubjectType).val(subArray[0]);

		var SubjectId = $('#' + inputIdPre + 'SubjectId');
		if (SubjectId)
			$(SubjectId).val(subArray[1]);

		var SubjectName = $('#' + inputIdPre + 'SubjectName');
		if (SubjectName)
			$(SubjectName).val(subArray[2]);

		var SubjectDepartmentId = $('#' + inputIdPre + 'SubjectDepartmentId');
		if (SubjectDepartmentId)
			$(SubjectDepartmentId).val(subArray[3]);

		var SubjectDepartmentName = $('#' + inputIdPre
				+ 'SubjectDepartmentName');
		if (SubjectDepartmentName)
			$(SubjectDepartmentName).val(subArray[4]);

		var SubjectDepartmentName = $('#' + inputIdPre + 'SubjectDistrict');
		if (SubjectDepartmentName)
			$(SubjectDepartmentName).val(subArray[5]);
	}
}

// 打开一个模态窗口
function openBigModalDialog(url) {
	return window.showModalDialog(encodeURI(url + '&isFromUrl=true'), window,
			'dialogHeight:800px;dialogWidth:900px;resizable:yes;maximize:yes');
}

// 翻页，注意翻页form的id必须为pageForm
function toPage(pageNo) {
	$("#pageNo").val(pageNo);
	$("#pageForm").submit();
}

// 批量删除
function batchDelete(url, checkBoxId)
{
	if(checkBoxChecked(checkBoxId))
	{
		if(confirm("确定要删除选中数据吗?"))
		{
			$("#pageForm").attr("action",url).submit();
		}
	}
}

// 批量处理
function batchProcess(processName,url, checkBoxId)
{
	if(checkBoxChecked(checkBoxId))
	{
		if(confirm("确定要批量"+processName+"选中数据吗?"))
		{
			$("#pageForm").attr("action",encodeURI(url)).submit();
		}
	}
}
 			
// 刷新列表页
function freshCurrentPage(pageNo) {
	$("#pageForm").submit();
}

// 显示所有数据
function showAllRows(rows) {
	$("#pageCount").val(rows);
	toPage(1);
}

/**
 * 表格排序
 * 
 * @param {}
 *            th
 */
function sortBy(th) {
	var th_class_current = $(th).attr('class');
	var th_db_col = $(th).attr('db_col');
	var order_by = '';
	if (th_class_current == 'table-sorted-none') {
		order_by = th_db_col + ' asc';// none->asc
	} else if (th_class_current == 'table-sorted-asc') {
		order_by = th_db_col + ' desc';// asc->desc
	} else if (th_class_current == 'table-sorted-desc') {
		order_by = '';// desc->none
	}

	$("#orderBy").val(order_by);
	$("#pageForm").submit();
}

// 检查所有css为notEmpty的元素是否已经填写了值
function checkAllNotEmptyInput() {
	var isOk = true;

	$(".notEmpty").each(function() {
				var id = $(this).attr("id");
				var label = $(this).attr("label");

				if (checkNull(id, lable = null ? "不能为空的字段" : label) == false) {
					isOk = false;
					return false;;
				}
			});

	return isOk;
}

// 检查某个TR内所有css为notEmpty的元素是否已经填写了值
function checkTrNotEmptyInput(trId) {
	var isOk = true;

	$("tr#" + trId + " .notEmpty").each(function() {
				var id = $(this).attr("id");
				var label = $(this).attr("label");

				if (checkNullByLabel(label) == false)// 定制化字段在
				// 阶段反馈、工单回复等阶段可能都有，所以其id有可能会重复，这里使用label来标志需要检查的输入框
				{
					isOk = false;
					return false;;
				}
			});

	return isOk;
}

// 检查是否为空
function checkNullByLabel(label) {
	var input = $("[label='" + label + "']");

	if ($(input).val() == "") {
		$(input).focus();
		alert("请填写 " + label);
		return false;
	}
	return true;
}

// 导出
function exportData(totalRows, url) {
	var exportExcel = true;

	if (totalRows > 500) {
		exportExcel = confirm("如果条数较多导出时可能需要等待一点时间，您确定导出吗？");
	}

	if (exportExcel) {
		// 从HTML页面导出excel使用
		$("#table_html").val("<table>"+$("#export_table").html()+"</table>");
		
		var action = $("form").attr("action");

		$("form").attr("action",encodeURI(url+"&isFromUrl=true"));
		$("form").submit();

		$("form").attr("action", action);
	}
}

function printme() {
	$("div#printDiv").printArea();
}

/**
 * 字典数据项选择
 * 
 * @param {}
 *            dictName 字典名称
 * @param {}
 *            keyField 存储key的input字段id
 * @param {}
 *            valueField 存储value的input字段id
 */
function selectFromDictionary(dictName, keyField, valueField, parentDictName,
		parentDictKey, dbFilter,multiSelect,callBack) {
	var dictUrl = '../Dictionary/Servlet?method=listItems4select&isFromUrl=true&dictname='
			+ encodeURI(dictName);

	dictUrl += '&parentDictName=' + encodeURI(parentDictName);
	dictUrl += '&parentDictKey=' + encodeURI(parentDictKey);
	dictUrl += '&dbFilter=' + encodeURI(dbFilter);
	dictUrl += '&multiSelect=' + encodeURI(multiSelect);
	dictUrl += '&selectedKeys='
			+ encodeURI($("#" + keyField).val().replace('multi:', ''));// 去掉multi:标识

	var returnValue = window.showModalDialog(dictUrl, this,
			'dialogHeight:600px;dialogWidth:700px;resizable:yes;maximize:yes');

	var keys = '';
	var values = '';
	// 返回的格式为 key1=value1;key2=value2
	if (returnValue != null) {
		var kvArray = returnValue.split(';');
		for (var i = 0; i < kvArray.length; i++) {
			var kv = kvArray[i].split('=');
			keys += kv[0] + ",";
			values += kv[1] + ",";
		}
		if (keys.length > 0) {
				keys =  keys.substr(0, keys.length - 1);
				values = values.substr(0, values.length - 1);
				if(true==multiSelect)
				{
					keys =  'multi:' +keys; // 加上multi:标识
				}
		}
	}

	$("#" + keyField).val(keys);
	$("#" + valueField).val(values);
	
	eval(callBack+"()");
}
/**
 * 根据字典key获取字典value并将结果放置到valueFiled字段中
 * @param {} dictName
 * @param {} dictKey
 * @param {} valueField
 */
function getDictValueByDictKey(dictName,dictKey,valueField)
{
		$.post(
						"../Dictionary/Servlet?method=getDictValueByDictKey", 
						{
							dictName:dictName,
							dictKey:dictKey
						}, 
						function(data, textStatus){
							$("#"+valueField).val(data);
						}
				);
}

/**
 * 根据java类获取字典数据
 * @param {} dictJavaClass
 * @param {} keyField
 * @param {} valueField
 * @param {} keyProp
 * @param {} valueProp
 */
function selectFromDictionaryByJavaClass(dictJavaClass, keyField, valueField, keyProp, valueProp,objFilter,callBack)
{
	var returnStr = openBigModalDialog('../Proxy/Servlet?servlet='+dictJavaClass+'&method=select4this&'+objFilter);
	
	var obj = JSON.parse(returnStr);
	
	$("#" + keyField).val(obj[keyProp]);
	$("#" + valueField).val(obj[valueProp]);
	$("#" + keyField+"_4all").val(returnStr);
	
	eval(callBack+"('"+returnStr+"')");
}

/**
 * 从字典中选择并在指定table中添加一行
 * 
 * @param {}
 *            dictName 字典名
 * @param {}
 *            tableId 表格id
 * @param {}
 *            存储key的input字段id
 */
function createRowFromDictionary(dictName, tableId, keyField) {
	var selectedKeys = "";
	$("[name='" + keyField + "']").each(function() {
				selectedKeys += $(this).val() + ";"
			});

	var dictUrl = '../Dictionary/Servlet?method=listItems4select&isFromUrl=true&multiSelect=true&dictname='
			+ encodeURI(dictName) + '&selectedKeys=' + encodeURI(selectedKeys);

	var returnValue = window.showModalDialog(dictUrl, this,
			'dialogHeight:600px;dialogWidth:500px;resizable:yes;maximize:yes');

	// 返回的格式为 key1=value1;key2=value2
	if (returnValue != null) {
		
		returnValue = returnValue.replace('multi:','');
		var valueArray = returnValue.split(';');

		for (i = 0; i < valueArray.length; i++) {
			var keyValue = valueArray[i].split('=');
			var key = keyValue[0];
			var value = keyValue[1];

			var trHtml = "<tr>";
			trHtml += "	<td>" + key + "</td>";
			trHtml += "	<td>" + value + "</td>";
			trHtml += "	<td> ";
			trHtml += "		<input type=\"hidden\" name=\"" + keyField
					+ "\" value=\"" + key + "\">";
			trHtml += "		<input type=\"button\" class=\"button button_delete\" title=\"删除\" onClick=\"$(this).parents('tr').remove();\" /> ";
			trHtml += "	</td>";
			trHtml += "</tr>";

			// 不重复添加
			if ($('input[name=' + keyField + '][value=' + key + ']').val()) {
				continue;
			} else {
				$("#" + tableId).append(trHtml);
			}
		}
	}
}

/**
 * tab页选择
 * 
 * @param {}
 *            tableId
 */
function useAsTab(tableId, width, height) {
	// 设置div的默认样式
	$("#" + tableId).find("td").each(function() {
		var div_id = $(this).attr("div_id");
		var div = $("#" + div_id);
		$(div).css("width", width);
		if (height != null) {
			$(div).css("height", height);
		}
		$(div).css("margin", "0px auto");// div本身水平居中
		$(div).css("overflow", "auto");// div滚动条
			// $(div).css("border","1px solid #0055a8");//div边框
		});

	// 注册点击事件
	$("#" + tableId).find("td").click(function() {
				// 显示点击的tab
				var show_div_id = $(this).attr("div_id");

				// 没有show_div_id则不处理
				if (show_div_id == null)
					return;

				$("#" + show_div_id).show();
				// 设置样式
				$(this).addClass("sub_title_table_tab");

				// 隐藏其他tab
				$("#" + tableId).find("td").each(function() {
							var div_id = $(this).attr("div_id");
							if (show_div_id != div_id) {
								$("#" + div_id).hide();
								// 设置样式
								$(this).removeClass("sub_title_table_tab");
							}
						});
			});

	// 模拟点击第1个tab页
	$("#" + tableId + " tr td:first").click();
}

/**
 * 确认删除数据
 * 
 * @param {}
 *            url
 */
function confirmDelete(url) {
	if (confirm("确认要删除该行记录吗？")) {
		$('#pageForm').attr('action', url);
		$('#pageForm').submit();
	}
}

// 删除一行记录
function deleteIt(baseUrl,keyColumnName,keyValue) {
				$.post
				(
					encodeURI(baseUrl+'&method=allowDelete4this&'+keyColumnName+'_4del='+keyValue), 
					{Action : "post"}, 
					function(data, status) {
					if (data == "true") {
						if (confirm("确定要删除吗？")) {
								var url = baseUrl+'&method=delete4this&'+keyColumnName+'_4del='+keyValue;
								$.post(
									encodeURI(url), 
									{Action : "post"}, 
									function(data, status) {
										if (status == "success") {
											alert("删除成功");
											if (window.opener) {
												try {
													window.opener.eval("freshCurrentPage()");
													window.opener.eval("freshMe()");
												} catch (e) {
													;
												};
											}
											if (window.dialogArguments) {
												try {
													window.dialogArguments
															.eval("freshCurrentPage()");
													window.dialogArguments.eval("freshMe()");
												} catch (e) {
													;
												};
											}
											freshCurrentPage();
											window.close();
										} else {
											alert("删除失败");
										}
									});
						}
					} else {
						alert(data);
					}
				});
	
	
	/**
	if (confirm("确定要删除吗？")) {
		$.post(encodeURI(url), {
					Action : "post"
				}, function(data, status) {
					if (status == "success") {
						alert("删除成功");
						if (window.opener) {
							try {
								window.opener.eval("freshCurrentPage()");
								window.opener.eval("freshMe()");
							} catch (e) {
								;
							};
						}
						if (window.dialogArguments) {
							try {
								window.dialogArguments
										.eval("freshCurrentPage()");
								window.dialogArguments.eval("freshMe()");
							} catch (e) {
								;
							};
						}
						window.close();
					} else {
						alert("删除失败");
					}
				});
	}**/
}

function deleteOneRow(baseUrl,keyColumnName,keyValue)
{
	//if (confirm("确定要删除吗？")) {
				$.post(encodeURI(baseUrl+'&method=allowDelete4this&'+keyColumnName+'_4del='+keyValue), {
					Action : "post"
				}, function(data, status) {
					if (data == "true") {
						//$('#pageForm').attr('action',baseUrl+'&method=delete4this&'+keyColumnName+'_4del='+keyValue);
						//$('#pageForm').submit();
						deleteIt(baseUrl,keyColumnName,keyValue);
					} else {
						alert(data);
					}
				});
	//}
}

/**
 * 同步获取数据
 * @param {} url
 */
function getDataAsync(url,formId)
{
	$.ajax({  
          type : "post",  
          url  : encodeURI(url+"&isFromUrl=true"),  
          data : $("#"+formId).serialize(),  
          async : false,// 设置为同步调用，保证调用完以后返回结果
          success : function(data){  
            result = data;  
          }  
     });
	
	return result;
}

/**
 * 执行操作
 * @param {} url
 */
function postAsync(url)
{
	var rst = getDataAsync(url);
	if("true"==rst)
	{
		alert("操作成功！");
		freshCurrentPage();
	}
	else
	{
		alert("出问题了，请联系开发商处理。");
	}
}

/**
 *  绑定两个select进行级联操作
 * @param {} fromDictName 父字典名称
 * @param {} fromDictInputId 父字典select的id
 * @param {} toDictName 子字典名称
 * @param {} toDictInputId 子字典select的id
 */
function bindSelect(fromDictName,fromDictInputId,toDictName,toDictInputId,clearToDict)
{
	// 首先清空 子字典 中的内容
	if(clearToDict==true)
	{
		$("#"+toDictInputId).html("<select id='"+toDictInputId+"'><option value=''>--请选择--</select>");
	}
	
	// 其次监听父字典的变化
	$("#"+fromDictInputId).change(function(){
			$.post(
						"../Dictionary/Servlet?method=getDictHtml", 
						{
							fromDictName:fromDictName,
							fromDictKey:$("#"+fromDictInputId).val(),
							toDictName:toDictName,
							selectName:toDictInputId
						}, 
						function(data, textStatus){
							$("#"+toDictInputId).html(data);
						}
				);
		});
}

/**
 * 根据唯一索引字段检查待录入数据的唯一性
 */
function checkUniqueAndSave()
{
	var checkOk = false;
	$.post( 
					"Servlet?method=checkId4this",  
					$("#addOrModifyForm").serialize(), 
					function (data, textStatus){ 
						this; 
						if(data=="true")  
						{ 
							alert("该数据已录入系统,请勿重复录入。"); 
							checkOk = false;
						} 
						else 
						{ 
							checkOk = true;
							addOrModirySubmit();
						} 
				}); 
	return checkOk;
}

/**
 * 根据唯一索引字段检查待录入数据的唯一性
 */
function checkUniqueAndSave(servlet)
{
	var checkOk = false;
	$.post( 
					"../Proxy/Servlet?servlet="+servlet+"&method=checkId4this",  
					$("#addOrModifyForm").serialize(), 
					function (data, textStatus){ 
						this; 
						if(data=="true")  
						{ 
							alert("该数据已录入系统,请勿重复录入。"); 
							checkOk = false;
						} 
						else 
						{ 
							checkOk = true;
							addOrModirySubmit();
						} 
				}); 
	return checkOk;
}

/**
 * 提交保存或修改 
 */
function addOrModirySubmit() 
{ 
	$("#addOrModifyForm").submit(); 
} 

/**
 * 绑定全选和取消全选
 * @param {} checkAllBoxId
 * @param {} checBoxId
 */
function bindCheckAllBox(checkAllBoxId,checkBoxId)
{
		// 全选 取消全选
		$("#"+checkAllBoxId).click(function(){
				$("[id='"+checkBoxId+"']").each(function(){
						if($("#"+checkAllBoxId).prop("checked")==true )
						{
							// 全选时，只对显示的行进行操作
							if( $(this).parents('tr').css('display')!='none')
							{
								$(this).prop("checked",true);//全选
							}
						}
						else
						{
							// 取消全选时，只对显示的行进行操作
							if( $(this).parents('tr').css('display')!='none')
							{
								$(this).prop("checked",false);//取消全选
							}
						}
				});
		});
}

/**
 * 检查是否有checkbox选中
 * @param {} checkBoxId
 * @return {}
 */
function checkBoxChecked(checkBoxId)
{
			var selectedSomeOne = false;
			$("[name='"+checkBoxId+"']").each(function(){
					if(selectedSomeOne == false){
						if($(this).prop("checked")==true){
							selectedSomeOne = true;
						}
					}
				}
			);
			
			if (!selectedSomeOne)
			{
				alert("未选中任何数据，请选择后再操作。");
			}
			
			return selectedSomeOne;
}

/**
 * 设置某个字段为只读
 * @param {} fieldId
 */
function setReadonly(fieldId){
	$("#"+fieldId).attr("readOnly","readOnly");
	$("#"+fieldId).css("background","#eeeeee");
	$("#"+fieldId).removeAttr("onclick");// 解除已绑定的点击事件
	
	
	$("#"+fieldId+"_4show").attr("readOnly","readOnly");
	$("#"+fieldId+"_4show").css("background","#eeeeee");
	$("#"+fieldId+"_4show").removeAttr("onclick");// 解除已绑定的点击事件
	
	$("#"+fieldId.replace("_4show","")+"_clear_btn").hide();// 隐藏输入框右侧的清空按钮
}

/**
 * 从树上选择数据
 * @param {} treeName
 * @param {} keyField
 * @param {} valueField
 * @param {} filter
 */
function selectFromTree(treeName, keyField, valueField,filter) {
	var dictUrl = '../Tree/Servlet?method=list4select&isFromUrl=true&name='+ encodeURI(treeName);

	dictUrl += '&flter=' + encodeURI(filter);
	dictUrl += '&select_ids='
			+ encodeURI($("#" + keyField).val().replace('multi:', ''));// 去掉multi:标识

	var returnValue = window.showModalDialog(dictUrl, this,
			'dialogHeight:600px;dialogWidth:700px;resizable:yes;maximize:yes');

	var keys = '';
	var values = '';
	// 返回的格式为 key1=value1;key2=value2
	if (returnValue != null) {
		var kvArray = returnValue.split(';');
		for (var i = 0; i < kvArray.length; i++) {
			var kv = kvArray[i].split('=');
			keys += kv[0] + ",";
			values += kv[1] + ",";
		}
		if (keys.length > 0) {
			keys = 'multi:' + keys.substr(0, keys.length - 1);// 加上multi:标识
			values = values.substr(0, values.length - 1);
		}
	}

	$("#" + keyField).val(keys);
	$("#" + valueField).val(values);
}

// 打开Layer
function openLayer(url) {
	if(url.indexOf("?")<0){url+="?"};
	layer.open({
		  type: 2,
		  title: ' ',
		  maxmin: false,
		  closeBtn: 1,
		  shadeClose: false, 
		  area : ['750px' , '500px'],
		  content: url
			});
}

/**
 * 在tab页中打开
 * 
 * @param {} title
 * @param {} url
 */
function openTab(title,url)
{
	top.mainFrame.eval("addTab('"+title+"','"+encodeURI(url+"&isFromUrl=true")+"')");
}

/**
 * 在window页中打开
 * 
 * @param {} title
 * @param {} url
 */
function openWindow(title,url)
{
	top.mainFrame.eval("openWindow('"+title+"','"+encodeURI(url+"&isFromUrl=true")+"')");
}
// =============================ArrayList=============================
// ArrayList.

function ArrayList() {
	this.index = -1;
	this.array = new Array();
}

ArrayList.prototype.clear = function() // 清空
{
	this.index = -1;
	this.array = new Array();
}

ArrayList.prototype.add = function(obj) // 添加
{
	if (this.getIndex(obj) == -1) {
		this.index = this.index + 1;
		this.array[eval(this.index)] = obj;
	}
}

ArrayList.prototype.get = function(index) // 根据索引取值
{
	return this.array[eval(index)];
}

ArrayList.prototype.size = function() // 获取ArrayList长度
{
	return this.index + 1;
}

ArrayList.prototype.getIndex = function(obj) // 根据值取出在ArrayList中索引
{
	var index = -1;
	for (var i = 0; i < this.array.length; i++) {
		if (this.array[i] == obj) {
			index = i;
			break;
		}
	}
	return index;
}

ArrayList.prototype.remove = function(index) // 根据索引删除
{
	var j = 0;
	var arrThis = this.array;
	var arrTemp = new Array();
	for (w = 0; w < arrThis.length; w++) {
		if (eval(index) != eval(w)) {
			arrTemp[j] = arrThis[w];
			j++;
		}
	}
	this.array = arrTemp;
	this.index = eval(j - 1);
}

ArrayList.prototype.removeValue = function(obj) // 根据值删除
{
	var j = 0;
	var arrThis = this.array;
	var arrTemp = new Array();
	for (w = 0; w < arrThis.length; w++) {
		if (obj != arrThis[w]) {
			arrTemp[j] = arrThis[w];
			j++;
		}
	}
	this.array = arrTemp;
	this.index = eval(j - 1);
}

ArrayList.prototype.toString = function() // 转换为字符串，中间用','分开
{
	var strResult = "";
	for (var i = 0; i < this.array.length; i++) {
		if (strResult == "")
			strResult = this.array[i];
		else
			strResult = strResult + "," + this.array[i];
	}
	return strResult;
}

/**
	 ** 加法函数，用来得到精确的加法结果
	 ** 说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
	 ** 调用：accAdd(arg1,arg2)
	 ** 返回值：arg1加上arg2的精确结果
	 **/
function accAdd(arg1, arg2) {
    var r1, r2, m, c;
    try {
        r1 = arg1.toString().split(".")[1].length;
    }
    catch (e) {
        r1 = 0;
    }
    try {
        r2 = arg2.toString().split(".")[1].length;
    }
    catch (e) {
        r2 = 0;
    }
    c = Math.abs(r1 - r2);
    m = Math.pow(10, Math.max(r1, r2));
    if (c > 0) {
        var cm = Math.pow(10, c);
        if (r1 > r2) {
            arg1 = Number(arg1.toString().replace(".", ""));
            arg2 = Number(arg2.toString().replace(".", "")) * cm;
        } else {
            arg1 = Number(arg1.toString().replace(".", "")) * cm;
            arg2 = Number(arg2.toString().replace(".", ""));
        }
    } else {
        arg1 = Number(arg1.toString().replace(".", ""));
        arg2 = Number(arg2.toString().replace(".", ""));
    }
    return (arg1 + arg2) / m;
}

//javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。   
function accMul(arg1,arg2){   
  
    var m=0,s1=arg1.toString(),s2=arg2.toString();   
  
    try{m+=s1.split(".")[1].length}catch(e){}   
  
    try{m+=s2.split(".")[1].length}catch(e){}   
  
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)   
  
}  

//给Number类型增加一个add方法，调用起来更加方便。
Number.prototype.add = function (arg) {
    return accAdd(arg, this);
};

Number.prototype.mul = function (arg) {
    return accMul(arg, this);
};

