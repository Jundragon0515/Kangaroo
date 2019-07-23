(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("report");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Static("Static01","294","139","83","47",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("신고사유");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static02","294","201","47","38",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("제목");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static03","294","343","52","55",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("내용");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Combo("cause","432","140","168","45",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            obj.set_font("normal 13pt/normal \"Arial\"");
            var cause_innerdataset = new nexacro.NormalDataset("cause_innerdataset", obj);
            cause_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">curse</Col><Col id=\"datacolumn\">욕설</Col></Row><Row><Col id=\"codecolumn\">illegality</Col><Col id=\"datacolumn\">불법</Col></Row><Row><Col id=\"codecolumn\">obscene</Col><Col id=\"datacolumn\">음란</Col></Row><Row><Col id=\"codecolumn\">fraud</Col><Col id=\"datacolumn\">사기</Col></Row></Rows>");
            obj.set_innerdataset(cause_innerdataset);
            obj.set_text("");
            this.addChild(obj.name, obj);

            obj = new Edit("title","432","202","337","38",null,null,null,null,null,null,this);
            obj.set_taborder("4");
            obj.set_font("normal 10pt/normal \"Arial\"");
            obj.set_textAlign("left");
            this.addChild(obj.name, obj);

            obj = new TextArea("contents","432","312","337","137",null,null,null,null,null,null,this);
            obj.set_taborder("5");
            obj.set_dragscrolltype("horz");
            obj.set_wordWrap("english");
            obj.set_font("normal 10pt/normal \"Arial\"");
            obj.set_textAlign("left");
            this.addChild(obj.name, obj);

            obj = new Button("Button00","699","463","71","37",null,null,null,null,null,null,this);
            obj.set_taborder("6");
            obj.set_text("신고하기");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Static("Static04","294","256","106","34",null,null,null,null,null,null,this);
            obj.set_taborder("7");
            obj.set_text("작성자");
            obj.set_font("normal 13pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            obj = new Edit("writer","432","255","337","37",null,null,null,null,null,null,this);
            obj.set_taborder("8");
            obj.set_font("normal 10pt/normal \"Arial\"");
            obj.set_textAlign("left");
            this.addChild(obj.name, obj);

            obj = new Static("Static00","300","24","449","98",null,null,null,null,null,null,this);
            obj.set_taborder("9");
            obj.set_text("신고하기");
            obj.set_textAlign("center");
            obj.set_font("normal 30pt/normal \"Arial\"");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("report.xfdl", function() {

        this.Button00_onclick = function(obj,e)
        {
        	var cause = this.cause.text;
        	var title = this.title.value;
        	var writer = this.writer.value;
        	var contents = this.contents.value;

         		var params = "cause="+cause;
         			params += " title="+title;
         			params += " writer="+writer;
         			params += " contents="+contents;

        	console.log(cause+title+writer+contents);

        	this.transaction("report","../../report","","",params,"saveCallback");
        };

        this.saveCallback = function(){
        	alert("신고가 접수 되었습니다.");
        }

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.Static02.addEventHandler("onclick",this.Static02_onclick,this);
            this.title.addEventHandler("onchanged",this.Edit00_onchanged,this);
            this.Button00.addEventHandler("onclick",this.Button00_onclick,this);
            this.Static00.addEventHandler("onclick",this.Static00_onclick,this);
        };

        this.loadIncludeScript("report.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
