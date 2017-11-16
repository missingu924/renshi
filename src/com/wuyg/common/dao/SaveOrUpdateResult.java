package com.wuyg.common.dao;

public class SaveOrUpdateResult
{
	private boolean saveSuccess;// 保存结果
	private long savedRows;// 保存的行数

	private boolean updateSuccess;// 更新结果
	private long updatedRows;// 更新的行数

	public boolean isSaveSuccess()
	{
		return saveSuccess;
	}

	public void setSaveSuccess(boolean saveSuccess)
	{
		this.saveSuccess = saveSuccess;
	}

	public long getSavedRows()
	{
		return savedRows;
	}

	public void setSavedRows(long savedRows)
	{
		this.savedRows = savedRows;
	}

	public boolean isUpdateSuccess()
	{
		return updateSuccess;
	}

	public void setUpdateSuccess(boolean updateSuccess)
	{
		this.updateSuccess = updateSuccess;
	}

	public long getUpdatedRows()
	{
		return updatedRows;
	}

	public void setUpdatedRows(long updatedRows)
	{
		this.updatedRows = updatedRows;
	}

	public boolean isSuccess()
	{
		return saveSuccess || updateSuccess;
	}

	@Override
	public String toString()
	{
		if (savedRows > 0 || updatedRows > 0)
		{
			String s = "";

			if (isSaveSuccess())
			{
				s += "共计新增" + savedRows + "条数据，";
			}

			if (isUpdateSuccess())
			{
				s += "共计更新" + updatedRows + "条数据，";
			}

			return s + "操作成功。";
		} else
		{
			return "没有需要新增的数据";
		}
	}

}
