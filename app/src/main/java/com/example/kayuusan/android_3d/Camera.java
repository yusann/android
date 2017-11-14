package com.example.kayuusan.android_3d;

import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLU;

// カメラ
public class Camera
{
	float aspect;		// アスペクト比
	
	// アスペクト比設定
	void setAspect( float aspect )
	{
		this.aspect = aspect;
	}
	
	// カメラ設定
	void set( GL10 gl )
	{
		// プロジェクションマトリクス設定
		gl.glMatrixMode( GL10.GL_PROJECTION );		// 射影変換を設定
		gl.glLoadIdentity();							// 変換行列を初期化（単位行列）
			// カメラの基本仕様（遠近法の基づいて射影変換）
			//                 視野角, アスペクト比（横/縦）, 視界の最も手前の点, 視界の最も奥の点
		GLU.gluPerspective( gl, 45.0f,               aspect,              10.0f,         1000.0f );
		
		// ビューマトリクス設定
			//               モデル変換を設定
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glLoadIdentity();
		GLU.gluLookAt( gl, 0.0f, 90.0f, 120.0f,		// 位置
							0.0f, 0.0f, -80.0f,		// 注視点
							0.0f, 1.0f, 0.0f );		// 上方向
	}
}
